# PlanPolslWebScraping

Trying to web scrape time schedule from [plan.polsl.pl](https://plan.polsl.pl/) for faculty of [Applied Mathematics](https://www.polsl.pl/rms/)

## 1. How to use it
First you need get your schedule ```id```. Here's instruction how to get it.
1. Go to [plan.polsl.pl](https://plan.polsl.pl)
2. Find your group's schedule, and DON'T click it
3. Press F12 to open to open Chrome's dev tools
4. Now you can click on your schedule
5. Open network tab and search for something which looks like this: ...
6. From the url copy ```id``` query parameter
7. Now you can instantiate ```Schedule``` class with property which you've copied
8. 