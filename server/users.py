import abc


class ModelDecorator:
    def __init__(self, database_connection):
        self._init_db(database_connection)

    def __call__(self, class_):
        """Adds methods for databse instance manipulation"""
        class_.select = None
        class_.filter = None
        class_.insert = None
        class_.delete = None
        class_.update = None
        class_.iterator = class_.get_iterator_class()
        return class_

    def _init_db(self, database_connection):
        pass


class ModelFactory:
    def __init__(self, model):
        self.model = model

    def get_instance(self, **params):
        """Returns the specified instance based on params or creates it if it does not exist"""
        pass


class UserIterator:
    def __init__(self, user_list):
        """ user_list is a collection of users (list, tuple, set, etc) """
        pass

    def has_next(self):
        """True if there are more users to iterate, or False otherwise (Iteration stopped)"""
        pass

    def next(self):
        """Puts the cursor to the next user and returns it. Raises IterationStop if there are no more
        users in order to be compatible to the built-in Python iteration system"""
        pass

    def current(self):
        """Returns the current user from iterator"""
        pass


class ModelTemplate(abc.ABC):
    @abc.abstractmethod
    def get_iterator_class(self):
        pass


@ModelDecorator("sqlite:///users.sqlite3")  # equivalent to User = ModelDecorator("sqlite:///users.sqlite3"")(User)
class User(ModelTemplate):
    def __init__(self, username, password, email, first_name, last_name):
        pass

    def get_iterator_class(self):
        return UserIterator
