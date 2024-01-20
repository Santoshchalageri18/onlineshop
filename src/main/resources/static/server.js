const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000;

// Sample in-memory database to store doctor status
const doctorStatus = {};

app.use(bodyParser.json());

app.post('/updateDoctorStatus', (req, res) => {
    const { email, status } = req.body;

    // Update doctor status in the database
    doctorStatus[email] = status;

    // Respond with a success message (you can customize this)
    res.json({ message: 'Doctor status updated successfully.' });
});

app.listen(port, () => {
    console.log(`Server is running at http://localhost:${port}`);
});
