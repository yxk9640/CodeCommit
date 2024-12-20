const fieldValues = {
        "formField-d8024f175e991014c862a2c5ba770000": "Yogesh",
        "formField-d8024f175e991014c862a2c5ba770001": "Kalapala",
        "formField-d8024f175e991014c862a2c5ba770002": "yogeshkal119@gmail.com",
        "formField-d8024f175e991014c862a2c5ba770003": "India",
        "formField-d8024f175e991014c862a3612dad0008": "United States of America",
        "formField-bd6a270fe4881014c7fe773b509d0000": "India",
        "formField-d8024f175e991014c862a3612dad0001": "Option1",
        "formField-d035b08ee7ef1014c86d9631a6ef0000": "Computer Science",
        "formField-d8024f175e991014c862a3612dad0004": "Masters",
        "formField-bd6a270fe4881014c7fe773b509d0001": "Option1",
        "formField-bd6a270fe4881014c7fe773b509d0003": "07/04/2026",
        "formField-d8024f175e991014c862a3fc4e850000": "Option3",
        "formField-bd6a270fe4881014c7fe77d70d9d0000": "Value2",
        "formField-ae80ac61066b1014c90d967d5a130000": "07/04/2026",
        "formField-d8024f175e991014c862a532994f0004": "Option2",
        "formField-bd6a270fe4881014c7fe77d70d9d0007": "N/A",
        "formField-bd6a270fe4881014c7fe77d70d9d0008": "Option2",
        "formField-bd6a270fe4881014c7fe77d70d9d000c": "0",
        "formField-d8024f175e991014c862a5cd9b2a0001": "Option2",
        "formField-bd6a270fe4881014c7fe78729ff30000": "Option1",
        "formField-42ecc6a4ed401014c9196bf25b180001": "Option2",
        "formField-41e735608cd81014c926844425bf0000": "Option2",
        "formField-bd6a270fe4881014c7fe790dd5610008": "Option2"
};

Object.keys(fieldValues).forEach(fieldId => {
        const fieldElement = document.querySelector(`[data-automation-id="${fieldId}"]`);
        if (fieldElement) {
            // Assuming the target element contains an input field or can accept text
            const input = fieldElement.querySelector("input, textarea");
            if (input) {
                input.value = fieldValues[fieldId];
                input.dispatchEvent(new Event("input")); // Trigger input event to ensure change is registered
            } else {
                console.warn(`No input or textarea found in field: ${fieldId}`);
            }
        } else {
            console.warn(`Field with data-automation-id "${fieldId}" not found.`);
        }
    });
