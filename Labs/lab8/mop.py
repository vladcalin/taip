class Watcher(object):
    def __init__(self, config):
        self.config = config
        self.events = config["events"]
        self.rules = config["rules"]
        self.watched = None

        self.call_stack = []

    def __call__(self, obj):
        self.watched = obj
        for event_name, event_func_name in self.events.items():
            self.wrap_watched_func(event_name, event_func_name)
        return obj

    def wrap_watched_func(self, event_name, event_func_name):
        func = getattr(self.watched, event_func_name)

        def wrapped_func(*args, **kwargs):
            self.call_stack.append(event_name)
            self.check_stack()
            return func(*args, **kwargs)

        setattr(self.watched, event_func_name, wrapped_func)

    def check_stack(self):
        for rule, action in self.rules.items():
            relevant = self.call_stack[-len(rule):]
            if list(rule) == relevant:
                action()
