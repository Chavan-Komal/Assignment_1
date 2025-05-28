//
function getWeather() {
  const city = document.getElementById("city").value;
  const units = document.getElementById("units").value;
  const apiKey = "c72efd19a3f1da84002549d118e5fe95"; // Replace with your OpenWeatherMap API key

  if (!city) {
    document.getElementById("errorMsg").innerText = "Please enter a city name.";
    document.getElementById("weatherResult").innerHTML = "";
    return;
  }

  const url = `https://api.openweathermap.org/data/2.5/weather?q=${encodeURIComponent(
    city
  )}&units=${units}&appid=${apiKey}`;

  fetch(url)
    .then((response) => {
      if (!response.ok) {
        throw new Error("City not found");
      }
      return response.json();
    })
    .then((data) => {
      const temp = data.main.temp;
      const weather = data.weather[0].main;
      const icon = data.weather[0].icon;
      const unitSymbol = units === "metric" ? "°C" : "°F";

      document.getElementById("weatherResult").innerHTML = `
        <h2>${data.name}</h2>
        <p><strong>Temperature:</strong> ${temp} ${unitSymbol}</p>
        <p><strong>Condition:</strong> ${weather}</p>
        <img src="https://openweathermap.org/img/wn/${icon}@2x.png" alt="${weather}">
      `;
      document.getElementById("errorMsg").innerText = "";
    })
    .catch((error) => {
      document.getElementById("weatherResult").innerHTML = "";
      document.getElementById("errorMsg").innerText = error.message;
    });
}
