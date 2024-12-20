//checks the document with field type and replaces
// Function to fill a form field dynamically based on its type
function fillFormField(field) {
    if (!field) return; // Skip if the field is null or undefined

    // Identify the field type and act accordingly
    if (field.tagName === 'TEXTAREA' || field.tagName === 'INPUT') {
        // Text fields
        field.value = 'Sample Text'; // Replace with your desired value
        field.dispatchEvent(new Event('input')); // Trigger input event
    } else if (field.tagName === 'SELECT') {
        // Dropdown menus
        if (field.options.length > 1) {
            field.value = field.options[1].value; // Select the second option (customize as needed)
            field.dispatchEvent(new Event('change')); // Trigger change event
        }
    } else if (field.type === 'checkbox' || field.type === 'radio') {
        // Checkboxes or radio buttons
        field.checked = true; // Mark as checked
        field.dispatchEvent(new Event('change')); // Trigger change event
    }
}

// Select all form containers by their `data-automation-id` starting with "formField-"
const formContainers = document.querySelectorAll('[data-automation-id^="formField-"]');

// Loop through each form container to find the input fields and fill them
formContainers.forEach((container) => {
    const inputField = container.querySelector('textarea, input, select'); // Find input, textarea, or select
    fillFormField(inputField); // Fill the field
});

// If there's a submit button, submit the form
const submitButton = document.querySelector('button[type="submit"], input[type="submit"]');
if (submitButton) {
    console.log('Form filled successfully! Submitting...');
    submitButton.click(); // Submit the form
} else {
    console.warn('No submit button found.');
}
