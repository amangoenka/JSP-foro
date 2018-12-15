function firm(id) {
  var cor = confirm("Do you want delete thread?");
  if (cor == true) {
    window.location.replace("remove.jsp?id=" + id);
    return true;
  } else {
    return false;
  }
}