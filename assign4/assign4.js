/*
	Student Name: Edward Lovo
	Student Number: 000826715
	This is the JavaScript for assignment 3.
*/

document.addEventListener("DOMContentLoaded", function () {
    let score = 0;

    function createRandomCircle() {
        const svg = document.querySelector("#game-circle");
        const circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");

        const radius = Math.random() * 20 + 10;
        const x = Math.random() * (svg.clientWidth - radius * 2) + radius;
        const y = Math.random() * (svg.clientHeight - radius * 2) + radius;

        circle.setAttribute("cx", x);
        circle.setAttribute("cy", y);
        circle.setAttribute("r", radius);

        circle.addEventListener("click", function () {
            svg.removeChild(circle);
            score += 10;
            document.getElementById("score").textContent = score;
            createRandomCircle();
        });

        svg.appendChild(circle);
    }

    createRandomCircle();

    const addButton = document.createElement("button");
    const footer = document.querySelector("footer");
    addButton.classList.add("btn-primary");
    addButton.textContent = "Add Circle";
    addButton.addEventListener("click", createRandomCircle);
    document.body.insertBefore(addButton, footer);
});