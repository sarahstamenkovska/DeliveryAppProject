export const loadConsultations = () => {
    return [
        {
            "slotId": 5,
            "professor": {
                "id": "kostadin.mishev",
                "title": "м-р",
                "firstName": "Костадин",
                "lastName": "Мишев",
                "followers": [
                    {
                        "index": "170001",
                        "firstName": "Petko",
                        "lastName": "Petkovski"
                    }
                ]
            },
            "room": {
                "name": "114",
                "building": "TMF",
                "description": "на приземје, ходник десно од главниот влез, простории од десна страна"
            },
            "date": "2019-12-15",
            "dayOfWeek": null,
            "from": "10:00:00",
            "to": "12:00:00"
        },
        {
            "slotId": 6,
            "professor": {
                "id": "riste.stojanov",
                "title": "д-р",
                "firstName": "Ристе",
                "lastName": "Стојанов",
                "followers": [
                    {
                        "index": "170002",
                        "firstName": "Петре",
                        "lastName": "Петрев"
                    }
                ]
            },
            "room": {
                "name": "200аб",
                "building": "TMF",
                "description": "на втор кат"
            },
            "date": "2019-12-21",
            "dayOfWeek": "MONDAY",
            "from": "13:00:00",
            "to": "14:00:00"
        },
        {
            "slotId": 7,
            "professor": {
                "id": "riste.stojanov",
                "title": "д-р",
                "firstName": "Ристе",
                "lastName": "Стојанов",
                "followers": [
                    {
                        "index": "170002",
                        "firstName": "Петре",
                        "lastName": "Петрев"
                    }
                ]
            },
            "room": {
                "name": "200аб",
                "building": "TMF",
                "description": "на втор кат"
            },
            "date": "2019-12-21",
            "dayOfWeek": "MONDAY",
            "from": "18:00:00",
            "to": "19:00:00"
        },
        {
            "slotId": 8,
            "professor": {
                "id": "kostadin.mishev",
                "title": "м-р",
                "firstName": "Костадин",
                "lastName": "Мишев",
                "followers": [
                    {
                        "index": "170001",
                        "firstName": "Petko",
                        "lastName": "Petkovski"
                    }
                ]
            },
            "room": {
                "name": "114",
                "building": "TMF",
                "description": "на приземје, ходник десно од главниот влез, простории од десна страна"
            },
            "date": null,
            "dayOfWeek": "THURSDAY",
            "from": "19:00:00",
            "to": "21:00:00"
        },
        {
            slotId: 9,
            professor: {
                id: "dimitar.trajanov",
                title: "проф. д-р",
                firstName: "Димитар",
                lastName: "Трајанов",
                followers: []
            },
            room: {
                name: "114",
                building: "TMF",
                description: "на приземје, ходник десно од главниот влез, простории од десна страна"
            },
            date: null,
            dayOfWeek: "THURSDAY",
            from: "19:00:00",
            to: "21:00:00"
        }
    ]
};

export const getIngredients = () => {
    const data = loadConsultations().reduce((acc, curr) => {
        if (!acc[curr.professor.id]) {
            acc[curr.professor.id] = {
                id: curr.professor.id,
                professor: curr.professor,
                slots: []
            };
        }
        acc[curr.professor.id].slots.push(curr);
        return acc;
    }, {});
    return Object.values(data);
};

