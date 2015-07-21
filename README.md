# dropwiz-data

A little project to try and figure out how Jackson's serialization to XML works.
JSON "just works" most of the time but XML is tricky when we have a generic type.

The best solution seems to be to create a version of the generic class with the contained type
hard coded - see FixedTypeResult. Not a great solution as you'd need a new wrapper class for every type.