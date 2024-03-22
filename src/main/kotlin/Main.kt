// Преобразование массива в зигзаг
fun zigzagArray(arr: MutableList<Int>): List<Int> {
    arr.sort()
    for (i in 1 until arr.size - 1 step 2) {
        arr[i] = arr[i + 1].also { arr[i + 1] = arr[i] }
    }
    return arr
}

// Слейте два отсортированных массива в один отсортированный массив
fun mergeSortedArrays(arr1: List<Int>, arr2: List<Int>): List<Int> {
    return (arr1 + arr2).sorted()
}

// Найдите максимальное произведение трех чисел в массиве
fun maxProductOfThree(arr: List<Int>): Int {
    val sortedArr = arr.sorted()
    val n = arr.size
    return maxOf(
        sortedArr[n - 1] * sortedArr[n - 2] * sortedArr[n - 3], sortedArr[0] * sortedArr[1] * sortedArr[n - 1]
    )
}

// Реализуйте функцию, которая переворачивает массив
fun reverseArray(arr: List<Int>): List<Int> {
    return arr.reversed()
}

// Проверьте, содержит ли массив только четные числа.
fun containsOnlyEven(arr: List<Int>): Boolean {
    return arr.all { it % 2 == 0 }
}

// Найдите сумму всех элементов массива
fun sumOfElements(arr: List<Int>): Int {
    return arr.sum()
}

// Проверьте, содержит ли массив дубликаты.
fun containsDuplicates(arr: List<Int>): Boolean {
    return arr.toSet().size != arr.size
}

// Соедините два массива в один
fun concatenateArrays(arr1: List<Int>, arr2: List<Int>): List<Int> {
    return arr1 + arr2
}

// Переместите все нули в конец массива, не меняя порядок ненулевых элементов.
fun moveZeroesToEnd(arr: MutableList<Int>): List<Int> {
    val zeroes = arr.filter { it == 0 }
    val nonZeroes = arr.filter { it != 0 }
    return nonZeroes + zeroes
}

// Рассчитайте среднее значение элементов массива
fun averageOfElements(arr: List<Int>): Double {
    return arr.average()
}

// Найдите количество элементов массива, значение которых больше среднего арифметического всех элементов
fun countElementsGreaterThanAverage(arr: List<Int>): Int {
    val avg = arr.average()
    return arr.count { it > avg }
}

// Найдите второе по величине число в массиве
fun secondLargest(arr: List<Int>): Int? {
    val sortedSet = arr.toSet().sorted()
    return if (sortedSet.size < 2) null else sortedSet[sortedSet.size - 2]
}

// Удалите минимальный элемент из массива
fun removeMinElement(arr: MutableList<Int>): List<Int> {
    arr.remove(arr.minOrNull())
    return arr
}

// Разделите массив на два массива: в одном только четные числа, в другом — только нечетные
fun separateEvenOdd(arr: List<Int>): Pair<List<Int>, List<Int>> {
    val even = arr.filter { it % 2 == 0 }
    val odd = arr.filter { it % 2 != 0 }
    return even to odd
}

// Найдите все элементы, которые встречаются более одного раза в массиве
fun findDuplicates(arr: List<Int>): List<Int> {
    return arr.groupBy { it }.filter { it.value.size > 1 }.keys.toList()
}

// Переверните массив без использования встроенной функции reverse()
fun reverseArrayManually(arr: MutableList<Int>): List<Int> {
    for (i in 0 until arr.size / 2) {
        val temp = arr[i]
        arr[i] = arr[arr.size - i - 1]
        arr[arr.size - i - 1] = temp
    }
    return arr
}

// Удалите последний элемент из массива
fun removeLastElement(arr: MutableList<Int>): List<Int> {
    arr.removeAt(arr.size - 1)
    return arr
}

// Добавьте новый элемент в конец массива
fun appendElement(arr: MutableList<Int>, element: Int): List<Int> {
    arr.add(element)
    return arr
}

// Удалите элемент из массива по заданному индексу
fun removeElementByIndex(arr: MutableList<Int>, index: Int): List<Int> {
    arr.removeAt(index)
    return arr
}

// Вставьте новый элемент на заданную позицию в массиве
fun insertElementAtIndex(arr: MutableList<Int>, index: Int, element: Int): List<Int> {
    arr.add(index, element)
    return arr
}

// Создайте массив, в котором каждый элемент повторяется дважды
fun duplicateElements(arr: List<Int>): List<Int> {
    return arr.flatMap { listOf(it, it) }
}

fun countCharacterRepetitions(input: String): String {
    val counts = mutableMapOf<Char, Int>()

    for (char in input) {
        counts[char] = counts.getOrDefault(char, 0) + 1
    }

    val result = StringBuilder()
    for ((char, count) in counts) {
        result.append(char)
        result.append(count)
    }

    return result.toString()
}

// Тестирование функций
fun main() {
    val arr = listOf(1, 2, 3, 4, 5)
    val arr1 = listOf(1, 3, 5)
    val arr2 = listOf(2, 4, 6)

    println("Преобразование массива в зигзаг: ${zigzagArray(arr.toMutableList())}")
    println("Слияние двух отсортированных массивов: ${mergeSortedArrays(arr1, arr2)}")
    println("Максимальное произведение трех чисел: ${maxProductOfThree(arr)}")
    println("Перевернутый массив: ${reverseArray(arr)}")
    println("Содержит ли массив только четные числа: ${containsOnlyEven(arr)}")
    println("Сумма всех элементов массива: ${sumOfElements(arr)}")
    println("Содержит ли массив дубликаты: ${containsDuplicates(arr)}")
    println("Соединение двух массивов: ${concatenateArrays(arr1, arr2)}")
    println("Перемещение нулей в конец массива: ${moveZeroesToEnd(arr.toMutableList())}")
    println("Среднее значение элементов массива: ${averageOfElements(arr)}")
    println("Количество элементов больше среднего: ${countElementsGreaterThanAverage(arr)}")
    println("Второе по величине число в массиве: ${secondLargest(arr)}")

    println("Удаление минимального элемента из массива: ${removeMinElement(arr.toMutableList())}")
    println("Разделение массива на четные и нечетные числа: ${separateEvenOdd(arr)}")
    println("Элементы, встречающиеся более одного раза: ${findDuplicates(arr)}")
    println("Перевернутый массив без использования reverse(): ${reverseArrayManually(arr.toMutableList())}")
    println("Удаление последнего элемента из массива: ${removeLastElement(arr.toMutableList())}")
    println("Добавление нового элемента в конец массива: ${appendElement(arr.toMutableList(), 6)}")
    println("Удаление элемента по индексу из массива: ${removeElementByIndex(arr.toMutableList(), 2)}")
    println("Вставка элемента на заданную позицию: ${insertElementAtIndex(arr.toMutableList(), 2, 3)}")
    println("Массив с повторяющимися элементами: ${duplicateElements(arr)}")

    val input = "aabbbcccc"
    val result = countCharacterRepetitions(input)
    println("Преобразованная строка с подсчетом повторений: $result")
}