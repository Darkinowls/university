function ShowFilter() {
    document.getElementById("FilterDropped").classList.toggle("showFilter");
    document.getElementById("SorterDropped").classList.remove("showSorter");

    document.getElementById("FilterDropper").classList.toggle("AngleFilter");
    document.getElementById("SorterDropper").classList.remove("AngleSorter");
}

function ShowSorter() {
    document.getElementById("SorterDropped").classList.toggle("showSorter");
    document.getElementById("FilterDropped").classList.remove("showFilter");

    document.getElementById("SorterDropper").classList.toggle("AngleSorter");
    document.getElementById("FilterDropper").classList.remove("AngleFilter");
}


function ShowMenu() {
    document.getElementById("Bar").classList.toggle("showBar");
    document.getElementById("Menu").classList.toggle("Anime");
}

function showPop() {

    if (document.getElementById('pop').style.display === 'block'){
        document.getElementById('pop').style.display = 'none';
    }else document.getElementById('pop').style.display = 'block';

}


