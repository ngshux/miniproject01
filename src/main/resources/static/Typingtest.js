const typingText = document.querySelector(".typing-text p"),
inpField = document.querySelector(".wrapper .input-field");

function separateLetters(){
    document.getElementById("generated-poem").innerHTML.split("").array.forEach(element => {
        let spanTag = `<span>${element}</span>`;
        typingText.innerHTML += spanTag;
    });

    document.addEventListener("keydown", () => inpField.focus());
    typingText.addEventListener("click", () => inpField.focus());
}

function initTyping(){
    const characters = typingText.querySelectorAll("span");
    let typedChar = inpField.value;
    console.log(typedChar);
}

separateLetters();
print("HELLLLLLLLLLLLLLLLLO");
inpField.addEventListener("input", initTyping);
