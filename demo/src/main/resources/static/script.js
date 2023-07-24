// script.js

document.addEventListener("DOMContentLoaded", function () {
  fetchStudentInfo();
});

function fetchStudentInfo() {
  const apiUrl = "http://localhost:8080/api/v1/student";

  fetch(apiUrl)
    .then((response) => response.json())
    .then((data) => {
      // Assuming the API returns an object with student information
      displayStudentInfo(data);
    })
    .catch((error) => {
      console.error("Error fetching student information:", error);
    });
}

function displayStudentInfo(student) {
  // Update the HTML elements with the student's information
  document.getElementById("name").textContent = student.name;
  document.getElementById("email").textContent = student.email;
  document.getElementById("dob").textContent = student.dateOfBirth;
}
