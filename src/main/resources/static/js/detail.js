function deleteEvent(eventId) {
    fetch(`../${eventId}`, {
        method: "DELETE"
    }).then(_ => {
        window.location.href = "../list"
    })
}

function editEvent(eventId) {
    let name = document.getElementById("edit-name").value
    let location = document.getElementById("edit-location").value
    let date = document.getElementById("edit-date").value
    let attendees = document.getElementById("edit-attendees").value

    let entity = {
        "name": name,
        "location": location,
        "date": date,
        "attendees": attendees
    }
    let blob = new Blob([JSON.stringify(entity)], {type: "application/json"})

    fetch(`../edit/${eventId}`, {
        method: "POST",
        body: blob
    }).then(_ => {
        window.location.href = "../list"
    })
}