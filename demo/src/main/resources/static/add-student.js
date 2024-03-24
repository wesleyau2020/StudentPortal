function addStudent() {
  const formData = new FormData(document.getElementById("addStudentForm"));

  const studentData = {};
  formData.forEach((value, key) => {
    studentData[key] = value;
  });
  console.log("Student data to be sent to the backend:", studentData);

  // Call the backend API to add the student
  fetch("http://localhost:8080/api/v1/student", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(studentData),
  })
    .then((response) => {
      if (response.ok) {
        console.log("Student added successfully");
        // Redirect to the "index.html" page
        window.location.href = "index.html";
      } else {
        throw new Error("Failed to add student");
      }
    })
    .catch((error) => console.error("Error adding student:", error));
}

// Function to cancel and go back to index.html
function cancelAddStudent() {
  // Redirect to the "index.html" page
  window.location.href = "index.html";
}
