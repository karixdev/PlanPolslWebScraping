# PlanPolslWebScraping

Web scraping time schedules from [plan.polsl.pl](https://plan.polsl.pl/)

## How to use it
First you need get your schedule ```id```. Here's instruction how to get it:
1. Go to [plan.polsl.pl](https://plan.polsl.pl)
2. Find your group's schedule, and DON'T click it
3. Press F12 to open Chrome's dev tools
4. Now you can click on your schedule
5. Open network tab and search for request with name which looks like this: plan.php?type=...
6. From the url copy ```id``` query parameter.

Now, after you've gotten the ID to get schedule from web:
1. Instantiate ```Schedule``` class
2. Call ```download()``` on instantiated object.

To print schedule use static method ```print(Schedule schedule)``` from class ```SchedulePrinter```.