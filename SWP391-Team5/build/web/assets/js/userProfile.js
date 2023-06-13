/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let avatarImg = document.getElementById("avatarImage");
let inputFile = document.getElementById("input-file");

inputFile.onchange = function () {
    var file = inputFile.files[0];
    var fileName = file.name;
    var folderPath = "Assets2/upload/";

    avatarImg.src = URL.createObjectURL(inputFile.files[0]);
    var imageURL = folderPath + fileName;
    
}

document.getElementById('input-file').addEventListener('change', function () {
    var form = document.getElementById('myForm');
    var formData = new FormData(form);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', form.action, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Xử lý phản hồi từ máy chủ nếu cần
            console.log(xhr.responseText);
        }
    };
    xhr.send(formData);
});


