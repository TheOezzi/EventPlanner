function deleteEvent(eventId) {
    fetch(`../${eventId}`, {
        method: "DELETE"
    }).then(_ => {
        window.location.href = "../list"
    })
}