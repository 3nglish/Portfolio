import random as r
def hangmanGame():
# steps to select a random word from words.txt file
    with open("words.txt") as file:
        data = file.read().split()
        number = r.randint(0, len(data))
        word = data[number]
        lives = 6
        

# create a list of underscore -
# it contains exactly same number of underscore as the length of our random word
    lines = []
    wrongGuess = []
    mistakesMade = ' '
    for i in word:
        lines.append('_')
        wrongGuess.append('_')
    for i in word:
        wrongGuess.append('_')


#   counter variable is used to track number of wrong letters.
#   a user can make If it is 6 then terminate the program and print message

    counter = 0
    wordCounter = 0
    while True:
        print("Your remaining lives is :", lives)
        letter = input('\nGuess your letter :')
        if letter in word:
            for i in range(0, len(word)):
                if word[i] == letter:
                    lines[i] = letter
                    
            
        else:  # letter is not in the word
            mistakesMade = letter
            for i in range(0, len(word)):
                if wrongGuess[wordCounter] != letter:
                    wrongGuess[wordCounter] = mistakesMade
            counter += 1
            wordCounter +=1
            lives -= 1
    # print the word with inserted letters
        print("\nBelow is a list of letters IN the word")
        for i in lines:
            print(i, end=" ")
        
        print("\n Below is a list of letters NOT in the word, its multipied by 2 for your mistakes :)")    
        for i in wrongGuess:
            print(i, end=" ") 
          
        
    # check letters remained in the list

        cnt = "".join(lines).count('_')

        if cnt == 0 or counter == 6:
            break
# end of while loop
    
        
    if counter >= 6:
        print("\n\n\n You lost")
        print("\nThe word was" , word) 
        lives =0
    else:
        print("\n\n\n You WON")
        
def playAgain():
    play_again = True
    
   
    
    while play_again:
        print("\nSorry to use numbers...")
        print("\nBut I have to ask....")
        play = int(input("\nWould you like to play again?\n"
        +"Enter 1 for yes 0 for no"))
        
        if play == 0:
            play_again = False
            
        if play == 1:
            play_again = True
            print("\nStarting a new game...")
            hangmanGame()
            
        else:
            break

def main():
    hangmanGame()
    playAgain()
    
    
main()


