import sys
import traceback
import logging
import os
import time

def FormatStackTrace():
    exc_type, exc_obj, exc_tb = sys.exc_info()
    exc_st = traceback.extract_tb(exc_tb)

    error = ""
    for entry in exc_st:
        error += "\tFile: {0}\n".format(entry[0])
        error += "\tLine: {0}\n".format(entry[1])
        error += "\tFunc: {0}\n".format(entry[2])
        error += "\tText: {0}\n".format(entry[3])
    return error

# DECORATOR
def ErrorHandlingWrapper(attempts):
    def inner_dec(target):
        def inner_target(*args, **kwargs):
            for i in range(attempts):
                try:
                    return target(*args, **kwargs)
                except Exception as e:
                    error = "Failed to do something:\n"
                    error += FormatStackTrace()
                    error += "{0}\t{1}".format(args, kwargs)
                    logging.info(error)
                    time.sleep(1)

            error = "Failed to do something:\n"
            error += FormatStackTrace()
            error += "{0}\t{1}".format(args, kwargs)
            logging.critical(error)

        return inner_target
    return inner_dec

# DECORATOR
def MeesageLoggingWrapper():
    def inner_dec(target):
        def inner_target(*args, **kwargs):
            logging.info("Entering {0}".format(target.__name__))
            return target(*args, **kwargs)
        return inner_target
    return inner_dec
