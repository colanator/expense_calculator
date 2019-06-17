/*Map personMapCmdLine = [
    'T': [expenses: Integer.parseInt(args[0]) ?: 0, deviance: 0, to_H: 0, to_L: 0],
    'H': [expenses: Integer.parseInt(args[1]) ?: 0, deviance: 0, to_T: 0, to_L: 0],
    'L': [expenses: Integer.parseInt(args[2]) ?: 0, deviance: 0, to_T: 0, to_H: 0]    
]*/
Map personMapOne = [
    'T': [expenses: 1000, deviance: 0, to_H: 0, to_L: 0],
    'H': [expenses: 1000, deviance: 0, to_T: 0, to_L: 0],
    'L': [expenses: 1000, deviance: 0, to_T: 0, to_H: 0]    
]
Map personMapTwo = [
    'T': [expenses: 100, deviance: 0, to_H: 0, to_L: 0],
    'H': [expenses: 200, deviance: 0, to_T: 0, to_L: 0],
    'L': [expenses: 300, deviance: 0, to_T: 0, to_H: 0]    
]
Map personMapThree = [
    'T': [expenses: 100, deviance: 0, to_H: 0, to_L: 0],
    'H': [expenses: 100, deviance: 0, to_T: 0, to_L: 0],
    'L': [expenses: 300, deviance: 0, to_T: 0, to_H: 0]    
]
Map personMapFour = [
    'T': [expenses: 230, deviance: 0, to_H: 0, to_L: 0],
    'H': [expenses: 444, deviance: 0, to_T: 0, to_L: 0],
    'L': [expenses: 722, deviance: 0, to_T: 0, to_H: 0]    
]

void calculate_expenses(Map personMap){
    int no_of_persons = personMap.size()
    int total_expenses = 0
    int expense_per_person = 0

    personMap.each { person, values ->
        total_expenses += values.expenses
    }

    expense_per_person = total_expenses / no_of_persons

    personMap.each{ person, values ->
        values.deviance = values.expenses - expense_per_person
    }

    if(personMap['T'].deviance == 0){
        personMap['T'].to_H = 0
        personMap['T'].to_L = 0
    }
    if(personMap['T'].deviance < 0){
        if(personMap['H'].deviance > 0 && personMap['L'].deviance > 0){
            personMap['T'].to_H = personMap['H'].deviance
            personMap['T'].to_L = personMap['L'].deviance
        }
        if((personMap['H'].deviance > 0 && personMap['L'].deviance < 0) || (personMap['H'].deviance > 0 && personMap['L'].deviance == 0)){
            personMap['T'].to_H = Math.abs(personMap['T'].deviance)
        }
        if((personMap['L'].deviance > 0 && personMap['H'].deviance < 0) || (personMap['L'].deviance > 0 && personMap['H'].deviance == 0)){
            personMap['T'].to_L = Math.abs(personMap['T'].deviance)
        }
    }

    if(personMap['H'].deviance == 0){
        personMap['H'].to_T = 0
        personMap['H'].to_L = 0
    }
    if(personMap['H'].deviance < 0){
        if(personMap['T'].deviance > 0 && personMap['L'].deviance > 0){
            personMap['H'].to_T = personMap['T'].deviance
            personMap['H'].to_L = personMap['L'].deviance
        }
        if((personMap['T'].deviance > 0 && personMap['L'].deviance < 0) || (personMap['T'].deviance > 0 && personMap['L'].deviance == 0)){
            personMap['H'].to_T = Math.abs(personMap['H'].deviance)
        }
        if((personMap['L'].deviance > 0 && personMap['T'].deviance < 0) || (personMap['L'].deviance > 0 && personMap['T'].deviance == 0)){
            personMap['H'].to_L = Math.abs(personMap['H'].deviance)
        }
    }

    if(personMap['L'].deviance == 0){
        personMap['L'].to_H = 0
        personMap['L'].to_T = 0
    }
    if(personMap['L'].deviance < 0){
        if(personMap['T'].deviance > 0 && personMap['H'].deviance > 0){
            personMap['L'].to_T = personMap['T'].deviance
            personMap['L'].to_H = personMap['H'].deviance
        }
        if((personMap['T'].deviance > 0 && personMap['H'].deviance < 0) || (personMap['T'].deviance > 0 && personMap['H'].deviance == 0)){
            personMap['L'].to_T = Math.abs(personMap['L'].deviance)
        }
        if((personMap['H'].deviance > 0 && personMap['T'].deviance < 0) || (personMap['H'].deviance > 0 && personMap['T'].deviance == 0)){
            personMap['L'].to_H = Math.abs(personMap['L'].deviance)
        }
    }

    println "T velkaa L:lle " + personMap['T'].to_L + " ja H:lle " +personMap['T'].to_H
    println "H velkaa L:lle " + personMap['H'].to_L + " ja T:lle " +personMap['H'].to_T
    println "L velkaa T:lle " + personMap['L'].to_T + " ja H:lle " +personMap['L'].to_H
}

println personMapOne
calculate_expenses(personMapOne)

println personMapTwo
calculate_expenses(personMapTwo)

println personMapThree
calculate_expenses(personMapThree)

println personMapFour
calculate_expenses(personMapFour)