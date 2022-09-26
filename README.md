# PlanPolslWebScraping

Trying to web scrape time schedule from [plan.polsl.pl](https://plan.polsl.pl/) for faculty of [Applied Mathematics](https://www.polsl.pl/rms/)

## Algorithm for calculating start time of lecture:
Assumptions while sending request to ```https://plan.polsl.pl/plan.php```:
- ```winW = 1000```
- ```winH = 1000```

Then table with schedule starts at position ```SCHEDULE_MIN_TOP = 237``` and height of one hour is ```ONE_HOUR_HEIGHT = 45```. And time schedule always starts at ```SCHEDULE_START_TIME = 8```. 

```java
// Returns value in hours
double calculateStartTimeOfLecture(int courseTop) {
    int dTop = courseTop - SCHEDULE_MIN_TOP;
    double ratio = dTop / ONE_HOUR_HEIGHT;
    
    ratio /= 0.25;
    int ceiledNumberOfQuarters = (int) Math.ceil(ratio);
    ceiledNumberOfQuarters *= 15;
    
    return ceiledNumberOfQuarters / 60.0f + SCHEDULE_START_TIME;
}
```