const baseUrl = "http://localhost:8080";

const formSearch = document.querySelector("form.research-form");
const sectionAccommodations = document.querySelector("#hebergements");

formSearch.addEventListener("submit", async (event) => {
    event.preventDefault(); // IMPORTANT : empêche le refresh de la page
    const searchInput = document.querySelector("#destination").value;
    const accommodations = await fetchAccommodations(searchInput);
    displayAccommodations(searchInput, accommodations);
});

const displayAccommodations = (citySearch, accommodations) => {
    const titleHTML = `<h2 class="section-title">Hébergement à ${citySearch}</h2>`;

    let accommodationsHTML = `<article class="hebergements-cards">`;
    accommodations.forEach(a => {
        accommodationsHTML += `
                    <a href="#">
                        <article class="card">
                            <img alt="Hôtel du port" src="images/hebergements/fred-kleber.jpg">
                            <div class="card-content">
                                <div class="card-txt">
                                    <h3 class="card-title">${a.title}</h3>
                                    <p class="card-subtitle">Nuit à partir de ${a.price}<span class="euro">€</span></p>
                                </div>
                                <div class="card-rating">
                                    <i aria-hidden="true" class="fa-xs fa-solid fa-star"></i>
                                    <i aria-hidden="true" class="fa-xs fa-regular fa-star"></i>
                                    <span class="sr-only">Note de ${a.rating} sur 5</span>
                                </div>
                            </div>
                        </article>
                    </a>`;
    });
    accommodationsHTML += `</article>`;

    sectionAccommodations.innerHTML = "";
    sectionAccommodations.innerHTML += titleHTML + accommodationsHTML;
}

const fetchAccommodations = async (searchInput) => {
    const response = await fetch(`${baseUrl}/api/accommodations?city=${searchInput}`);
    return response.json();
}