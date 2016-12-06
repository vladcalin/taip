import sys
import logging
import time

logging.basicConfig(
    level=logging.DEBUG,
    stream=sys.stdout
)

CACHE = {}


class TimingAndLoggingAspect(object):
    def __init__(self, func):
        self.func = func

    def __call__(self, *args, **kwargs):
        # beforeFunction
        logging.info("[before] Called {} with arguments {}, {}".format(self.func, args, kwargs))
        start_time = time.time()

        # functionCall
        result = self.func(*args, **kwargs)

        # afterFunction
        logging.info("[after]  Function call finished with result: {}".format(result))

        # timingStats
        logging.info("[timing] Function call duration: {:.2f} seconds".format(time.time() - start_time))
        return result

    def __repr__(self):
        return repr(self.func)


class CacheAspect:
    def __init__(self, func):
        self.func = func

    def __call__(self, *args, **kwargs):

        # cache lookup
        if self.func in CACHE:
            for cached in CACHE[self.func]:
                if cached[0] == args and cached[1] == kwargs:
                    logging.info("[Cache] Found in cache. Not executing")
                    return cached[2]
        else:
            # initialize cache for self.func
            CACHE[self.func] = []

        logging.info("[Cache] Not found in cache. Executing")
        result = self.func(*args, **kwargs)
        CACHE[self.func].append((args, kwargs, result))

    def __repr__(self):
        return repr(self.func)


@TimingAndLoggingAspect
def function1():
    print("Inside function1()")
    return True


@TimingAndLoggingAspect
def make_sum(x, y):
    print("Inside make_sum()")
    print("computing {} + {}".format(x, y))
    return x + y


@TimingAndLoggingAspect
@CacheAspect
def high_duration():
    print("Inside high_duration()")
    time.sleep(2)
    return


if __name__ == '__main__':
    function1()
    print("")
    make_sum(10, 15)
    print("")

    # show caching
    high_duration()
    print("")
    high_duration()
    print("")
