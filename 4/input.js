regExps = {
"exercise_1": /[A-Z][a-z]+/,
"exercise_2": /(088)[1-9]\d{6}/,
"exercise_3": /[^01]+/,
"exercise_4": /^[a-z][a-zA-Z0-9_.]{2,30}$/,
"exercise_5": /^(1500|1[0-4][0-9]{2}|[1-9][0-9][0-9]|[1-9][0-9]|[0-9])$/,
"exercise_6": /class=['"].*['"]/
};
cssSelectors = {
"exercise_1": "item > java.class1",
"exercise_2": "different > java.diffClass",
"exercise_3": "item > java.class1 > tag.class1.class2",
"exercise_4": "item#someId + item",
"exercise_5": "item > tag.class1.class2 > java.class1 + java.class1",
"exercise_6": "item#someID > item > item > item > item",
"exercise_7": "different > different#diffId2 > java.diffClass + java.diffClass",
"exercise_8": "item#someId"
};
