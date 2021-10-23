function createNew() {
    let name = document.getElementById("name").value
    let location = document.getElementById("location").value
    let date = document.getElementById("date").value
    let attendees = document.getElementById("attendees").value

    let entity = {
        "name": name,
        "location": location,
        "date": date,
        "attendees": attendees
    }
    let blob = new Blob([JSON.stringify(entity)], {type: "application/json"})

    fetch("../", {
        method: "POST",
        body: blob
    }).then(_ => {
        window.location.href = "../list"
    })
}
