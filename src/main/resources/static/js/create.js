function createNew() {
    let name = document.getElementById("create-name").value
    let location = document.getElementById("create-location").value
    let date = document.getElementById("create-date").value
    let attendees = document.getElementById("create-attendees").value

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
    document.getElementById('create-date').value = now.toISOString().slice(0, -1);
});
