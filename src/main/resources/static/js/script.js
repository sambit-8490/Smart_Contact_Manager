console.log("script loaded");

let currentTheme = getTheme();
//initially -->

document.addEventListener("DOMContentLoaded", () => {
  changeTheme(currentTheme);
});

//TODO:
function changeTheme() {
  //set to web page

  changePageTheme(currentTheme, currentTheme);
  //set the listener to toggle theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change theme button clicked");

    if (currentTheme === "dark") {
      //theme to light
      currentTheme = "light";
    } else {
      //theme to dark
      currentTheme = "dark";
    }
    changePageTheme(currentTheme, oldTheme);
  });
}

//set Theme to local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme to local storage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
  //Update in localstorage
  setTheme(currentTheme);

  //remove the current theme
  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }

  //set the current theme
  document.querySelector("html").classList.add(theme);

  //change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent =
    currentTheme == "light" ? "Dark" : "Light";
}
