# Responsiveness Assignment

### Overview

In this assignment, you'll be making your portfolio responsive. Essentially, you will be enhancing
the portfolio you made last week with a mobile-responsive layout.

### Before You Begin

* If you struggled with the portfolio design, ask a member of the instructional staff to provide you with the solution files. This will provide a starting point for the current assignment.

* You've learned a ton of material: HTML, CSS, GitHub, GitHub Pages, and Bootstrap. If you feel like you're falling behind, there's no need to panic. You'll have weeks to digest and master this material.

* We're diving into JavaScript next week, and HTML/CSS will start receiving less focus. Still, you'll find that a basic knowledge of HTML/CSS will help you understand JavaScript, especially when we use it to manipulate web pages.

### Submission on BCS

* Please submit both the deployed Github.io link to your homework AND the link to the Github Repository!

### Instructions

1. Create a new GitHub repositories and name it  `Responsive-Portfolio`.

2. Clone the repositories to your computer.

### Assignment Instructions - (No Bootstrap)

1. Copy the contents of `Basic-Portfolio` (your first homework solution) and paste the mentioned files into `Responsive-Portfolio`.

2. Note: Be sure not to include any dot files (e.g. .git, .gitignore) from the `Basic-Portfolio` repo.

3. Inside your `Responsive-Portfolio` folder, find your `styles.css` file. You will write your media queries at the bottom of `styles.css`.

4. Use three `@media screen` tags, each with one of these `max-width`s: `980px`, `768px` and `640px`.

   * You use `980px` because you never want any of the content to be cut off. Since the desktop layout is about 960px wide, you want the media queries to kick in before your content gets cut off.

   * `768px` is about the width of a tablet and `640px` is about the width of a phone in landscape.

5. Make the layout match the following screenshots:

   * `index.html`: [980px](../images/980-index.jpg), [768px](../images/768-index.jpg), [640px](../images/640-index.jpg)

   * `portfolio.html`: [980px](../Images/980-portfolio.jpg), [768px](../images/768-portfolio.jpg), [640px](../images/640-portfolio.jpg)

   * `contact.html`: [980px](../images/980-contact.jpg), [768px](../images/768-contact.jpg), [640px](../images/640-contact.jpg)

6. Make the position of the header `static` (the default positioning) when the screen is `640px` wide. The header design takes up a lot of room; you don't want it to stick to the top of a small screen and leave no room for the rest of your site.

7. Be sure to include the `viewport` tag in all your HTML files, otherwise your media-queries won't function as expected on mobile devices. _(Hint: You won't need to use exact pixels for anything other than the container)_

8. **Protip**: Use the Chrome extensions [Window Resizer](https://chrome.google.com/webstore/detail/window-resizer/kkelicaakdanhinjdeammmilcgefonfh) and [Browser Width](https://chrome.google.com/webstore/detail/browser-width/mlnegepkjlccabakompdmbcmdieaideh) to see the browser dimensions in Chrome.

9. Deploy your new portfolio (now with media queries!) to GitHub Pages.

### Submitting Your Work on [BootCampSpot](https://www.bootcampspot-v2.com/)

1. Submit the GitHub links to your portfolio repositories on GitHub.

2. Submit the link to your (GitHub Pages) deployed site in the same input field.

### BONUS

* Incorporate CSS animations in your portfolio. [More info here](http://www.w3schools.com/css/css3_animations.asp).

### Reminder: Submission on BCS

* Please submit the deployed Github.io link to your homework AND the link to the Github Repository!

- - -

### Minimum Requirements

Attempt to complete homework assignment as described in instructions. If unable to complete certain portions, please pseudocode these portions to describe what remains to be completed.

- - -

### One More Thing

If you have any questions about this project or the material we have covered, please post them in the community channels in slack so that your fellow developers can help you! If you're still having trouble, you can come to office hours for assistance from your instructor and TAs.

**Good Luck!**
