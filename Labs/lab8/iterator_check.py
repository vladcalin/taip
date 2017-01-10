from mop import Watcher

mocked_user_db = [
    # username  email              active   hashed_password
    ("admin", "admin@project.com", True, "ec02c59dee6faaca3189bace969c22d3"),
    ("root", "root@project.com", True, "c0cc256aa0933314a8bbfd1661137dcf"),
    ("vlad", "vlad@project.com", True, "86cd23bca679bd768f73a68cf25c12b7"),
    ("administrator", "administrator@project.com", True, "965c92bc449c16d169c5c10001687889")
]


def get_user_generator():
    """
    Just for testing purposes.
    """
    for user in mocked_user_db:
        yield user


def alert_next_next():
    print("next called twice without has_next")


watcher = Watcher({
    "events": {
        "next": "next",
        "hasnext": "has_next"
    },
    "rules": {
        ("next", "next"): alert_next_next
    }
})


@watcher
class UserIterator(object):
    def __init__(self):
        self.current_index = 0
        self.items = list(get_user_generator())
        self.user_count = len(self.items)

    def has_next(self):
        return self.current_index < self.user_count

    def next(self):
        to_return = self.items[self.current_index]
        self.current_index += 1
        return to_return


class UserManager(object):
    def get_user_iterator(self):
        return UserIterator()


if __name__ == '__main__':
    print("Demo safe state")
    iterator = UserManager().get_user_iterator()
    while iterator.has_next():
        user = iterator.next()
        print(user)

    print("Demo unsafe state")
    iterator = UserManager().get_user_iterator()
    iterator.next()
    iterator.next()
    iterator.next()
    iterator.next()
