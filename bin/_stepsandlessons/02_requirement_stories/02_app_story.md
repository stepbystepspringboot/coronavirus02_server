# Johns Hopkins University Center (JHU)

Of course I was watching TV and Corona Virus is the main story in March 2020. Johns Hopkins University Center for Systems Science and Engineering (JHU CSSE) was mentioned as the source for Corona Virus Data. So I ask the TV, where is this data kep?. The TV in my mind said, "check [GitHub]: https://github.com".



I pulled out my laptop and went to GitHub and man, on March 10, 2010 there was a few resources that I found. The main one I notice is this one: https://github.com/CSSEGISandData. It also reported global data for the whole planet, as a Comma Separated Values (CSV), for the previous day data. Here is the target github link I will use: https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data/csse_covid_19_daily_reports.



It reports these the data columns:

```
Province/State
Country/Region
Last Update
Confirmed
Deaths
Recovered
Latitude
Longitude
```



Wow I said, it would be neat to show off my Java, SrpingBoot, and Angular skillset. What if I accessed this JHU data using SpringBoot and Angular. Off I went with this motivation in mind. Actual my "TV told me to create a  CoronaVirus App". Yes I have conversation with my TV.



# The REST API Wish List


## Here is the Wish List

```
Get the date when the data was loaded.
Get a list of all the CoronaVirus for all region (contries).
Get a list of Corona Virus for a region (contry).
```



## What Should our REST API Look Like

```
/dataLoaded  
	Get the reported date for the Corona Virus.
/coronaVirusList 
	Get all the reported  Corona Virus.
/coronaVirusByRegionList?region=<whatevercountry>
	Get a region reported  Corona Virus.
```



## Cache Daily Data Read

For caching the data to be read for the last reported date:

```
/coronaVirusRegionsMap
	Return a Map entry of each region reported Corona Virus
/regionKeys
	If we get the Map it also provides the regions (countries) as the key for the map entry.
```

