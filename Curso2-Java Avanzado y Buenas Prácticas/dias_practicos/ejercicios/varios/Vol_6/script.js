'use strict';

/**
 *  =======================
 *  ··· P E R S O N A S ···
 *  =======================
 */
const persons = [
    {
        name: 'Pedro',
        age: 35,
        code: 'ES',
        infected: true,
        petName: 'Troski',
    },
    {
        name: 'Elisabeth',
        age: 14,
        code: 'UK',
        infected: true,
        petName: 'Firulais',
    },
    {
        name: 'Pablo',
        age: 25,
        code: 'ES',
        infected: false,
        petName: 'Berritxu',
    },
    {
        name: 'Angela',
        age: 18,
        code: 'DE',
        infected: false,
        petName: 'Noodle',
    },
    {
        name: 'Boris',
        age: 50,
        code: 'UK',
        infected: true,
        petName: 'Leon',
    },
    {
        name: 'Donald',
        age: 69,
        code: 'US',
        infected: false,
        petName: 'Pence',
    },
    {
        name: 'Pepito',
        age: 36,
        code: 'ES',
        infected: false,
        petName: 'Carbón',
    },
];

/**
 *  =======================
 *  ··· M A S C O T A S ···
 *  =======================
 */
const pets = [
    {
        petName: 'Troski',
        type: 'perro',
    },
    {
        petName: 'Firulais',
        type: 'perro',
    },
    {
        petName: 'Berritxu',
        type: 'loro',
    },
    {
        petName: 'Noodle',
        type: 'araña',
    },
    {
        petName: 'Leon',
        type: 'gato',
    },
    {
        petName: 'Pence',
        type: 'perro',
    },
    {
        petName: 'Carbón',
        type: 'gato',
    },
];

/**
 *  =======================
 *  ··· A N I M A L E S ···
 *  =======================
 */
const animals = [
    {
        type: 'perro',
        legs: 4,
    },
    {
        type: 'araña',
        legs: 8,
    },
    {
        type: 'gato',
        legs: 4,
    },
    {
        type: 'loro',
        legs: 2,
    },
    {
        type: 'gallina',
        legs: 2,
    },
];

/**
 *  ===================
 *  ··· P A Í S E S ···
 *  ===================
 */
const countries = [
    {
        code: 'CN',
        name: 'China',
        population: 1439,
        infected: 81999,
    },
    {
        code: 'US',
        name: 'Estados Unidos',
        population: 331,
        infected: 112468,
    },
    {
        code: 'DE',
        name: 'Alemania',
        population: 83,
        infected: 57856202,
    },
    {
        code: 'ES',
        name: 'España',
        population: 46,
        infected: 72248,
    },
    {
        code: 'UK',
        name: 'Reino Unido',
        population: 67,
        infected: 17301,
    },
];

/**
 *  ###########################
 *  ## E J E R C I C I O   1 ##
 *  ###########################
 *
 *  Número total de infectados del array de personas.
 *
 */

// const totalInfected = persons.reduce( (accumulator, person) => {
//     if (person.infected) {
//         accumulator = accumulator + 1; //acc++
//     }
//     return accumulator;
// }, 0);

// const totalInfected2 = persons.filter((person) => person.infected);

// console.log ("totalInfected " + totalInfected2.length);

/**
 *  ###########################
 *  ## E J E R C I C I O   2 ##
 *  ###########################
 *
 *  Número total de infectados en el array de países.
 *
 */

// const totalInfectedByCountry = countries.reduce ((accumulator, country) => {
//     return accumulator = accumulator + country.infected;
// }, 0)

// console.log (totalInfectedByCountry);

/**
 *  ###########################
 *  ## E J E R C I C I O   3 ##
 *  ###########################
 *
 *  País con más infectados.
 *
 */

// const mostInfectedInCountry = countries.reduce ((acc, country) => {

//     // console.log ("acc: ", acc);
//     // console.log ("country", country);
//     // console.log ("-----------------");

//     if(country.infected > acc){
//         return acc = country.infected;
//     }
//     return acc;
// },0);

// // const mostInfectedCountry = countries.filter((country) => 
// // country.infected === mostInfectedInCountry);

// console.log ("most infected country ", mostInfectedInCountry);
// // console.log ("most infected country ", mostInfectedCountry[0]['name']);

/**
 *  ###########################
 *  ## E J E R C I C I O   4 ##
 *  ###########################
 *
 *  Array con el nombre de todas las mascotas.
 *
 */

// const allPets = pets.map((pet) => {
//     return pet.petName;
// });

// console.log (allPets);

/**
 *  ###########################
 *  ## E J E R C I C I O   5 ##
 *  ###########################
 *
 *  Array de españoles con perro.
 *
 */

// SOLUCIÓN
const spanishWithDogs = persons.filter((person) => {
    return (
      person.code === "ES" &&
      pets.find((pet) => {
        return pet.type === "perro" && pet.petName === person.petName;
      })
    );
  });
  console.log("spanishWithDogs", spanishWithDogs);


/**
 *  ###########################
 *  ## E J E R C I C I O   6 ##
 *  ###########################
 *
 *  Array con las personas. A mayores, este array debe incluír el objeto con los datos de su mascota.
 *
 *  {
 *      name: 'Pedro',
 *      age: 35,
 *      country: 'ES',
 *      infected: true,
 *      petName: {
 *          petName: ,
 *          type: 'perro',
 *      }
 *  }
 *
 */

 const personsAndPets = persons.map((person) => {
    return {
      ...person,
      petName: pets.find((pet) => pet.petName === person.petName),
    };
  });
  
  console.log(personsAndPets);

/**
 *  ###########################
 *  ## E J E R C I C I O   7 ##
 *  ###########################
 *
 *  Número total de patas de las mascotas de las personas.
 *
 */

//SOL BREO
// const totalLegs = pets
//     .map(pet => animals.find(animal => pet.type === animal.type).legs)
//     .reduce((acc, value) => acc + value, 0);

// console.log (totalLegs);


//SOL HAB
// const totalLegs = pets.reduce((acc, pet) => {
//     for (const animal of animals) {
//         if (animal.type === pet.type) {
//             acc += animal.legs;
//             // acc = acc + animal.legs;
//             break;
//         }
//     }
//     return acc;
// }, 0);

// console.log("num total patas: ", totalLegs);

/**
 *  ###########################
 *  ## E J E R C I C I O   8 ##
 *  ###########################
 *
 *  Array con las personas que tienen animales de 4 patas
 *
 */

// const persons4legAnimals = persons
//     .filter(person => {

//     const personPet = pets.find((pet) => person.petName === pet.petName);
//     // { petName: 'Troski', type: 'loro' }

//     const animalPet = animals.find((animal) => animal.type === personPet.type);
//     // { type: 'loro', legs: 2 }

//     return animalPet.legs === 4;
// })

// console.log (pets.find((pet) => 'Troski' === pet.petName));

// console.log (animals.find(animal => animal.type === 'perro'));
// console.log (persons4legAnimals);


/**
 *  ###########################
 *  ## E J E R C I C I O   9 ##
 *  ###########################
 *
 *  Array de países que tienen personas con loros como mascota.
 *
 */

// const personsWithParrots = persons.filter ((person) => {
//     return pets.find((pet) => person.petName === pet.petName && pet.type === "loro")
// }).map((person) => person.code);

// const coutriesWithParrotsArray = countries.filter((country) => {
//     return personsWithParrots.includes(country.code);
// });

// console.log (coutriesWithParrotsArray);


const peopleWithParrots = countries
    .filter( country =>
        persons.find(person => person.code === country.code 
            &&
        pets.find( pet => pet.petName === person.petName && )
);

console.log( "Ejercicio 9 ->" , peopleWithParrots )
/**


/**
 *  #############################
 *  ## E J E R C I C I O   1 0 ##
 *  #############################
 *
 *  Número de infectados totales (en el array de países) de los países con mascotas de ocho patas.
 *
 */

const totalInfected8legs = countries.filter(
    country =>
    persons.find(person => country.code === person.code &&
        pets.find(pet => pet.petName === person.petName &&
            animals.find(animal => animal.type === pet.type && animal.legs === 8)))
).reduce((acc, country) => acc + country.infected, 0);

// console.log(totalInfected8legs);

// console.log(totalInfectedWithSpiders);