import pyautogui
import time


def countdown():
	time.sleep(1)

	count = 5

	while (count > 0):
		print(count)
		time.sleep(1)
		count -= 1

	print("*SPAM INCOMING*")

msg = input("Message: ")
n = input("Amount: ")

print("\n| Message + Enter (msg) \n| Clipboard + Enter (cb) \n| Mouse Click (m) \n| Enter (e) \n| Mouse Click + Enter Spam (me) \n| Duplicator (d)\n") 
choice = input("Which type of spam?: ")

if choice.lower() in ['cb', 'clipboard']:
	countdown()
	for i in range(0,int(m)):
		pyautogui.hotkey("ctrl", "v")
		pyautogui.typewrite('\n')

elif choice.lower() in ['m', 'mouse']:
        countdown()
        for i in range(0, int(n)):
                pyautogui.click()

elif choice.lower() in ['e', 'enter']:
        countdown()
        for i in range(0, int(n)):
                pyautogui.typewrite('\n')

elif choice.lower() in ['me', 'mouse enter', 'mouse + enter']:
        countdown()
        for i in range(0, int(n)):
                pyautogui.click()
                pyautogui.typewrite('\n')

elif choice.lower() in ['d', 'duplicate', 'duplicator']:
        countdown()
        for i in range(0,int(n)):
                pyautogui.hotkey('ctrl', 'a')
                pyautogui.hotkey('ctrl', 'c')
                pyautogui.press(['right', 'enter'])
                pyautogui.hotkey('ctrl', 'v')
        
else:
	countdown()
	for i in range(0,int(n)):
		pyautogui.typewrite(msg + '\n')

