const tabs = document.querySelectorAll(".job-type");
// const all_content = document.querySelectorAll(".tab-content");

tabs.forEach((tab, idx) => {
  tab.addEventListener("click", (e) => {
    tabs.forEach((tab) => tab.classList.remove("active"));
    tab.classList.add("active");

    var line = document.querySelector(".line");
    line.style.width = e.target.offsetWidth + "px";
    line.style.left = e.target.offsetLeft + "px";

    // all_content.forEach((content) => content.classList.remove("active"));
    // all_content[idx].classList.add("active");
  });
});
