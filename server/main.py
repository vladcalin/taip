import logging

from log.autolog import ErrorHandlingWrapper, MeesageLoggingWrapper

def init_logging():
    logger = logging.getLogger("TAIP")
    logger.setLevel(logging.INFO)

    formatter = logging.Formatter("%(asctime)s-%(message)s")

    console_handler = logging.StreamHandler()
    console_handler.setLevel(logging.INFO)
    console_handler.setFormatter(formatter)
    logger.addHandler(console_handler)


    # setam logger-ul nostru custom ca logger principal
    logging.root = logger

init_logging()

@MeesageLoggingWrapper()
def func1():
    pass

@ErrorHandlingWrapper(3)
def func2():
    raise SystemError("error")

def main():
    func1()
    func2()

if __name__ == "__main__":
    main()