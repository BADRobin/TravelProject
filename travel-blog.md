# Travel Blog

## Objective
The goal for this project is to build a Travel Blog using Springboot and a MySQL Database.

## Features
### Homepage
#### Homepage Hero
- As the first thing people see when they visit your website, a hero section is the area that immediately shows up on the screen under your logo and menu
- Should contain one background image and a title
#### A list of travel locations
- Build a list of locations you travelled to
- The following information should be shown in the list:
  - The name of the city and country
  - The date of the visit (when you arrived)
  - A thumbnail of the city
#### A Map with the locations (optional)
- Add the location coordinates as pins on a Map
- More info below


### The detailed Blog page
- Header
  - City and Country name
  - The date of the visit (from and to)
- Gallery of images for the location
  - You can create your own gallery or use open source gallery frameworks
  - An example for vanilla HTML, CSS and JS
    - https://www.w3schools.com/howto/howto_js_slideshow.asp
- A description of the travel (can be Lipsum, but it always looks nicer with real text)
- The current weather in the city 
- Forecast (Bonus)
  * Add the forecast for the next few days in the detail section of a city
#### How to show the current weather of the travel location
* You can fetch the current weather (including an icon) of the travel location using the [OpenWeatherMap API](https://openweathermap.org/api)
* Show it as part of the information of your travel location

### Suggest new location page
- A form where any user can suggest new locations
- You can experiment with the various input elements, e.g. `<input type="date" />` or `<textarea>`

### The Traveler page
- A page to showcase the you as the authors of this website
- Be as creative as you want :)

## CMS

* Admins of the page should be able to add, edit and delete new locations
  * The city images can he public image URLs
  * (BONUS) allow image uploads to the server
* Any user can suggest a new location but Admins need to approve it before it shows up on the website
* (BONUS) Admins can change the background image of the Hero in the homepage
* (BONUS) Admins can choose cities to be featured in the homepage, by default it shows latest 5

### Map
- So far, we have not played around with embedding a Map. If you want to, feel free to play around with a Map API and how to integrate it in your app. You could then show the travel location on a map for every travel location.
* Feel free to use any Map APIs like Google Mapss, MapBox ot OpenStreetMap
- [Google Maps API](https://developers.google.com/maps/documentation/javascript/overview)
- [MapBox](https://www.mapbox.com)
- [OpenStreetMap](openstreetmap.org)

## Considerations
* The mockups provided are for example only, feel free to design/structure your site as you see fit;
* Have responsiveness in mind, do your best to make your website look good in both Desktop and Mobile browsers;
* The CMS can be Desktop only
- When starting to implement, focus on creating the HTML and CSS first, the code becomes much simpler when you already have an UI to code for;
- Style your website at will, feel free to use a CSS framework like Tailwind, Bulma or Bootstrap;
- You are allowed (and even encouraged) to ask other groups for help or help them;

## Submission
Submission deadline is on the `4th of December`
To submit the project, send us an email with the following information:
- Project:
  * Link to your project’s Github repository or Code Sandbox
  * A zip with the project is also acceptable
