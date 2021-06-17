const projectChart = new Chart(document.getElementById("projectChart"),  {
    type: 'doughnut',
    data: {
        labels: projectChartData.map(({label}) => label),
        datasets: [{
            label: 'My First Dataset',
            data: projectChartData.map(({value}) => value),
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)',
                'rgb(255, 205, 86)'
            ],
            hoverOffset: 4
        }]
    },
});

const employeeChart = new Chart(document.getElementById("employeeChart"),  {
    type: 'doughnut',
    data: {
        labels: employeeChartData.map(({lastName}) => lastName),
        datasets: [{
            label: 'My First Dataset',
            data: employeeChartData.map(({projectCount}) => projectCount),
            backgroundColor: [
                'rgb(255, 099, 132)',
                'rgb(054, 162, 235)',
                'rgb(255, 205, 086)',
                'rgb(153, 102, 255)',
                'rgb(075, 192, 192)',
                'rgb(255, 159, 064)',
                'rgb(000, 169, 080)',
                'rgb(201, 203, 207)',
                'rgb(088, 089, 091)'
            ],
            hoverOffset: 4
        }]
    },
});