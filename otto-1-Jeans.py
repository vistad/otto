# UI-test-1
# 1)Go to www.otto.de
# 2)Search for "Jeans"
# 3)Open the first product
# 4)Validate, that the product detail page contains the string "Artikelbeschreibung"

# time management
import time

# webdriver is a set of commands that control browser
from selenium import webdriver

# import class By to choose a search method
from selenium.webdriver.common.by import By

# initialize the browser driver that starts the browser
driver = webdriver.Chrome()

# time.sleep command sets a pause of 5 sec 
time.sleep(5)

# open the URL
driver.get("https://www.otto.de")
time.sleep(5)

# press the OK button to accept cookies 
driver.find_element(By.CSS_SELECTOR, '.cookieBanner__button').click()

# the method find_element lets us find the element - the main search field
textarea = driver.find_element(By.CSS_SELECTOR, ".squirrel_searchbar__input")

# the text I am searching
textarea.send_keys("Jeans")
time.sleep(5)

# find the submit button
submit_button = driver.find_element(By.CSS_SELECTOR, ".squirrel_searchbar__submit")

# press the submit button
submit_button.click()
time.sleep(5)

# search for the 1st element in the output field and click to choose it
driver.find_element(By.CSS_SELECTOR, '#san_resultSection > article.product').click()

# search for the text
if "Artikelbeschreibung" in driver.page_source: 
	print('Found it!') 
else: 
	print('Did not find it.') 

# close the browser window
driver.quit()
