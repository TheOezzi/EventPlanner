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

window.addEventListener('load', () => {
    const now = new Date();
    now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
    now.setMilliseconds(null)
    now.setSeconds(null)
    document.getElementById('date').value = now.toISOString().slice(0, -1);
});
