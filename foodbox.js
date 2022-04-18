// JavaScript source code
let slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
    showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");
    if (n > slides.length) { slideIndex = 1 }
    if (n < 1) { slideIndex = slides.length }
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex - 1].style.display = "inherit";
    dots[slideIndex - 1].className += " active";
}


function switchCuisine(cuisineType) {

    document.getElementById("homeView").style.display = "none";
    document.getElementById("image-gallery").style.display = "flex";

    let i;
    let cuisine = document.getElementsByClassName(cuisineType);
    let imageGallery = document.getElementsByClassName("image-gallery-item");

    for (i = 0; i < imageGallery.length; i++) {
        imageGallery[i].style.display = "none";
    }

    for (i = 0; i < cuisine.length; i++) {
        cuisine[i].style.display = "flex";
    }

}