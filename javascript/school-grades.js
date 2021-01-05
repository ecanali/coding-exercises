function gradeSwitcherWithIf(grade) {
    if (grade >= 90 && grade <= 100) {
        grade = "A"
    } else if (grade >= 80 && grade < 90) {
        grade = "B"
    } else if (grade >= 70 && grade < 80) {
        grade = "C"
    } else if (grade >= 60 && grade < 70) {
        grade = "D"
    } else if (grade < 60 && grade >= 0) {
        grade = "F"
    } else {
        grade = "Invalid grade"
    }

    return grade
}

console.log(gradeSwitcherWithIf(92))
console.log(gradeSwitcherWithIf(80))
console.log(gradeSwitcherWithIf(70))
console.log(gradeSwitcherWithIf(36))
console.log(gradeSwitcherWithIf(-92))
console.log(gradeSwitcherWithIf(120))

function gradeSwitcherWithIf2(grade) {
    let gradeA = grade >= 90 && grade <= 100
    let gradeB = grade >= 80 && grade < 90
    let gradeC = grade >= 70 && grade < 80
    let gradeD = grade >= 60 && grade < 70
    let gradeF = grade < 60 && grade >= 0
    
    if (gradeA) {
        grade = "A"
    } else if (gradeB) {
        grade = "B"
    } else if (gradeC) {
        grade = "C"
    } else if (gradeD) {
        grade = "D"
    } else if (gradeF) {
        grade = "F"
    } else {
        grade = "Invalid grade"
    }

    return grade
}

console.log(gradeSwitcherWithIf2(92))
console.log(gradeSwitcherWithIf2(80))
console.log(gradeSwitcherWithIf2(70))
console.log(gradeSwitcherWithIf2(36))
console.log(gradeSwitcherWithIf2(-92))
console.log(gradeSwitcherWithIf2(120))

function gradeSwitcherWithSwitch(grade) {
    let gradeA = grade >= 90 && grade <= 100
    let gradeB = grade >= 80 && grade < 90
    let gradeC = grade >= 70 && grade < 80
    let gradeD = grade >= 60 && grade < 70
    let gradeF = grade < 60 && grade >= 0
    
    switch (true) {
        case gradeA:
            grade = "A"
            break
        case gradeB:
            grade = "B"
            break
        case gradeC:
            grade = "C"
            break
        case gradeD:
            grade = "D"
            break
        case gradeF:
            grade = "F"
            break  
        default:
            grade = "Invalid grade"
            break
    }

    return grade
}

console.log(gradeSwitcherWithSwitch(92))
console.log(gradeSwitcherWithSwitch(80))
console.log(gradeSwitcherWithSwitch(70))
console.log(gradeSwitcherWithSwitch(36))
console.log(gradeSwitcherWithSwitch(-92))
console.log(gradeSwitcherWithSwitch(120))