const findAllUrl = "http://localhost:8085/hotels/findall";
const findByNameUrl = "http://localhost:8085/hotels/findbyname/";
const addUrl = "http://localhost:8085/hotels/add";
const row = document.querySelector('.row')
const inputBox = document.getElementById('inputBox');
const searchButton = document.querySelector('.search-button')
const searched = document.querySelector('.searched')
const add_hotel = document.querySelector('.add_hotel');
const my_modal = document.querySelector('.my_modal');
const add = document.querySelector('.add');
const hotel_name = document.getElementById('hotel_name')
const hotel_location = document.getElementById('hotel_location')
const hotel_price = document.getElementById('hotel_price')
const hotel_img = document.getElementById('hotel_img')

async function fetchHotels() {
    const fetchUrl = await fetch(findAllUrl);
    const response = await fetchUrl.json();
    getAllHotels(response)
}
fetchHotels();
function getHotelsAfterAdd(){
    console.log("fetched")
    fetchHotels();
}
function getAllHotels(data) {
    let html = ``;
    data.forEach(element => {
        const elem = `
        <div class="col-sm hotel">
        <div style="width:300px !important;">
        <div class="left-side">
            <img src="${element.imageUrl}" alt="">
            <h5 class="name">${element.name}</h5>
        </div>
        <div class="right-side">
            <h5 class="location">${element.location}</h5>
            <h6 class="price">${element.price}</h6>
        </div>
        </div>
    </div>
        `
        html += elem;
    });
    row.innerHTML = html;
}
searchButton.addEventListener('click', () => {
    fetchFindByName();
})

async function fetchFindByName() {
    if (inputBox.value == "") {
        searched.innerHTML = "please enter the hotel name"
    }
    else {
        const fetchUrl = await fetch(findByNameUrl + inputBox.value);
        if (fetchUrl.status == 404) {
            searched.innerHTML = "hotel not found for name " + inputBox.value
        }
        else {
            const response = await fetchUrl.json();
            let html = `
            <div class="col-sm hotel">
        <div class="left-side">
            <img src="${response.imageUrl}" alt="">
            <h5 class="name">${response.name}</h5>
        </div>
        <div class="right-side">
            <h5 class="location">${response.location}</h5>
            <h6 class="price">${response.price}</h6>
        </div>
    </div>
            `
            searched.innerHTML = html;
        }
    }
}
add_hotel.addEventListener('click', (e) => {
    my_modal.classList.toggle('show')
})
let clicked=false;
add.addEventListener("click", async () => {
    let data = {
        name: hotel_name.value,
        location: hotel_location.value,
        price: hotel_price.value,
        imageUrl: hotel_img.value

    };
    const options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    fetch(addUrl, options)
        .then(res => res.json())
        .then(res => console.log(res));
    clicked=true;
})
if(clicked){
    getHotelsAfterAdd();
}