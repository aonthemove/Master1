/**
 * Get all matches and profile data for initial render
 */
axios.get('/api/match').then(matchData => {
    axios.get('/api/profile').then(profileData => {
        load(matchData.data, profileData.data);
    });
});

load = (matchData, profileData) => {
    let index = 0;
    const renderProfile = profileData => Object.keys(profileData)
        .forEach(key => $(`input[name=${key}][value=${profileData[key]}]`).prop("checked", true))

    matchData = matchData.map(card => ({...card, img: `https://source.unsplash.com/user/kalvisuals/294x444?sig=${card.id}`}))

   
    const incrementIndex = (i, length) => (i + 1) % length;
    const checkIndex = (i, length) => i >= length ? 0 : i;

    const loadImages = () => {
        $('.front').append(`<img class="next-img" src="${matchData[index].img}" alt="profiile pic" />`);
        $('.front').append(`<img class="third-img" src="${matchData[(index + 1) % matchData.length].img}" alt="profiile pic" />`);
    }


    const renderMatches = function () {
        if (matchData.length) {
            $('.current-img').remove();
            $('.next-img').addClass('current-img').removeClass('next-img');
            $('.third-img').addClass('next-img').removeClass('third-img');
            $('.front').append(`<img class="third-img" src="${matchData[(index + 2) % matchData.length].img}" alt="profiile pic" />`);
            console.log("src", $('.current-img').attr('src'))
            $('.name').text(matchData[index].name);
            $('.age').text(matchData[index].age);
            $('.bio').text(matchData[index].bio);
        } else {
            $('button').unbind();
            $('.front').text("You have no more matches");
            $('.back').text("Try again later");
        }
        $('#remaining').text(matchData.length);
    }

    $('.rate-btn').on('click', function () {
        if(parseInt($(this).val())) {
            axios.put('/api/dislike', JSON.stringify({personId: matchData[index].id}), {
                headers: {
                    'Content-Type': 'application/json',
                }
            })
            matchData.splice(index, 1);
            index = checkIndex(index, matchData.length)
        } else {
            index = incrementIndex(index, matchData.length)
        }
        console.log("data", matchData);
        console.log("index", index);
        renderMatches();
    })

    $('.exit').on('click', () => {
        let profile = {};
        Object.keys(profileData).forEach(key => profile[key] = $(`input[name='${key}']:checked`).val())

        axios.put('/api/profile', JSON.stringify(profile), {
                headers: {
                    'Content-Type': 'application/json',
                }
            })
             .then(() => {
                axios.get('/api/match').then(matchData => {
                matchData = matchData.data
                renderMatches()
            })
             })

        $('#modal').hide()
    })

    $('.profile-link').on('click', () => $('#modal').show())


    loadImages();
    renderMatches();
    renderProfile(profileData);
}
