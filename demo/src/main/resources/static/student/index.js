// script.js
const apiUrl = "http://localhost:8080/api/v1/student";

document.addEventListener("DOMContentLoaded", function () {
  fetchStudentInfo();
});

function fetchStudentInfo() {
  fetch(apiUrl)
    .then((response) => response.json())
    .then((data) => {
      // Populate the table with student data
      const studentTable = document.getElementById("studentTable");
      const tbody = studentTable.querySelector("tbody");

      data.forEach((student) => {
        const row = document.createElement("tr");
        row.innerHTML = `
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.dob}</td>
                <td>${student.age}</td>
                <td>
                <button class="edit-btn" onclick="editStudent(${student.id})">Edit</button>
                <button class="delete-btn" onclick="deleteStudent(${student.id})">Delete</button>
                </td>
            `;
        tbody.appendChild(row);
      });
    });
}

function navigateToAddStudentPage() {
  window.location.href = "add.html";
}

// Function for edit action
window.editStudent = function (studentId) {
  // Fetch the existing student data first
  fetch(`${apiUrl}/${studentId}`)
    .then((response) => response.json())
    .then((existingStudent) => {
      // Use a simple prompt to get name and email
      const updatedName = prompt("Enter updated name:", existingStudent.name);
      const updatedEmail = prompt("Enter updated name:", existingStudent.email);

      // Create an object with the updated data
      const updatedStudent = {
        name: updatedName,
        email: updatedEmail,
      };

      // Perform the PUT request to update the student
      fetch(`${apiUrl}/${studentId}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedStudent),
      })
        .then((response) => response.json())
        .then((editedStudent) => {
          console.log("Student updated:", editedStudent);
          // Refresh the page to update the table with the new data
          location.reload();
        })
        .catch((error) => console.error("Error updating student:", error));
    })
    .catch((error) =>
      console.error("Error fetching existing student data:", error)
    );
};

window.deleteStudent = function (studentId) {
  fetch(`${apiUrl}/${studentId}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (response.ok) {
        console.log("Student deleted successfully");
        // Refresh the page to update the table with the new data
        location.reload();
      } else {
        throw new Error("Failed to delete student");
      }
    })
    .catch((error) => console.error("Error deleting student:", error));
};
