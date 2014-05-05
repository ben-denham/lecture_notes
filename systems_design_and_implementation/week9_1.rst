Chris Mayhew - Software Quality Assurance - Look at the difference between
software quality assurance and traditional quality assurance.

PERT
----

Each task has:

* Early start - The earliest this task could start, based on earliest finishes
  of previous tasks
* Task length - The time this task will take.
* Early Finish - Early start + Task length
* Late start - Late finish - task length
* Slack = Late start - early start
* Late finish = The latest this task could finish, based on the project deadline
  or the earliest "late start" of a dependent task. The latest finish of the
  final task should be copied from the early finish.

The tasks where there is 0 slack are on the **critical path**.

There will be at least 1 critical path, but there may be multiple critical
paths, but generally there is only 1.

If the critical path is running late, the whole project is definitely running
late. Other tasks running late might not be such a big issue.
