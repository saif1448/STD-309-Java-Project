Boolean Expressions Guide for Python

=====================================================

What is a Boolean?

A boolean is a data type in Python and in most programming languages.

It can only hold two possible values:

True

False

There is no value in between. Just true or false.

Think of booleans like a yes or no question:

"Is the light on?"

Yes → True

No → False

"Is it raining?"

Yes → True

No → False

=====================================================

Purpose of Booleans

Booleans are used to make decisions in programs - like whether a student
passes or fails, to answer yes or no questions, or to check if a
condition is met. They are often the result of comparisons

------------------------------------------------------------------------

Code example 1:

is_raining = True

        is_sunny = False

Explanation:

is_raining = True → It is raining

        is_sunny = False → It is not sunny

------------------------------------------------------------------------

Code example 2:

score = 85

passed = score\>= 75

print(passed)

Output:

True

Explanation

85 is greater than or equal to 75, so the expression evaluates to true.

=====================================================

Quick Reminder for Comparison Operators

Comparison operators compare values and return a Boolean (True or False)

=====================================================

Quick Reminder for Assignment Operators

Assignment operators are symbols that assigns or gives a value to a
variable

=====================================================

Boolean Operators

Boolean operators are words that combine conditions / modify True or
False values

=====================================================

Code Example Using Boolean Operators

Example 1:

age = 15

has_ticket = True

can_enter = age \>= 13 and has_ticket

print(can_enter)

Output:

True

Explanation: Both conditions are True (age \>= 13 and has_ticket), so
and makes the whole expression True

=====================================================

If/Else statements

Example 1 : Checking if a light is off

light_on = False

if not light_on:

    print("The room is dark.")

else:

    print("The light is on.")

Output: The room is dark.

Explanation:

light_on is False

not light_on becomes True

So the program prints "The room is dark."

Example 2 : Student Grade Check

score = 78

if score \>= 75:

    print("You passed!")

else:

    print("Try again next time.")

Output: You passed!

Explanation: The condition score \>= 75 is True because 78 ≥ 75, so the
first block runs and prints "You passed!"

Tip: Always end your if and else lines with a colon (:) and indent the
next line (usually 4 spaces).

Example 3: Game Over Check

lives = 0

if lives \> 0:

    print("Keep playing!")

else:

    print("Game Over!")

Output: Game Over!

Explanation: lives \> 0 is False (since lives = 0), so Python skips the
if block and runs the else block instead.

Example 4: Shopping Discount

total = 120

if total \> 100 or total == 100:

    print("You get a discount!")

else:

    print("No discount today.")

Output: You get a discount!

Explanation: The or operator checks if either condition is True. Here,
total \> 100 is True, so the condition passes even though the second one
doesn't need to be checked.

Tip: Use or when at least one condition should make the statement True.

=====================================================

Nested If/Else statements

Example 1: Game Power-Up Check

has_key = True

has_shield = True

level = 5

if has_key:

    print("You unlocked the gate!")



    if has_shield and level >= 5:

        print("Bonus unlocked: Super Armor!")

    else:

        print("Keep going to get your shield bonus.")

else:

    print("You need a key to enter!")

------------------------------------------------------------------------

Code Example 1 Explanation:

------------------------------------------------------------------------

First condition:

if has_key → has_key is True, so Python goes inside this block.

It prints: You unlocked the gate!

------------------------------------------------------------------------

Nested if condition: if has_shield and level \>= 5:

has_shield → True

level \>= 5 → True (because 5 is equal to 5)

Both are True → the entire condition is True.

So it prints: Bonus unlocked: Super Armor!

Note: The else inside runs only if the nested condition was False. But
here, it's True, so it's skipped.

------------------------------------------------------------------------

Final Output:

You unlocked the gate!

Bonus unlocked: Super Armor!

------------------------------------------------------------------------

Key Takeaways

A nested if means one if statement inside another.

Python runs the inner if only if the outer one is True.

Indentation (spacing) shows which if belongs to which block.

=====================================================

Key points to remember:

Booleans only have two values: True or False

They're often the result of a comparison like \>, \<, ==, or !=

Boolean operators (and, or, not) combine multiple conditions

= means assign, while == means compare

Booleans are often used inside if, elif, and else to make decisions

Don't forget colons after if/elif/else statements!

Make sure to indent your code correctly.

=====================================================
