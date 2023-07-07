const allStar = document.querySelectorAll('.rating .mainstar');
const ratingValue = document.querySelector('.rating input');
const skill1 = document.querySelectorAll('.rating .skill1');
const ratingSkill1 = document.querySelector('.rt1 input');
const skill2 = document.querySelectorAll('.rating .skill2');
const ratingSkill2 = document.querySelector('.rt2 input');
const skill3 = document.querySelectorAll('.rating .skill3');
const ratingSkill3 = document.querySelector('.rt3 input');

allStar.forEach((item, idx)=> {
	item.addEventListener('click', function () {
		let click = 0;
		ratingValue.value = idx + 1;

		allStar.forEach(i=> {
			i.classList.replace('bxs-star', 'mainstar');
			i.classList.remove('active');
		});
		for(let i=0; i<allStar.length; i++) {
			if(i <= idx) {
				allStar[i].classList.replace('mainstar', 'bxs-star');
				allStar[i].classList.add('active');
			} else {
				allStar[i].style.setProperty('--i', click);
				click++;
			}
		}
	});
});

//Skill1
skill1.forEach((item, idx)=> {
	item.addEventListener('click', function () {
		let click = 0;
		ratingSkill1.value = idx + 1;

		skill1.forEach(i=> {
			i.classList.replace('bxs-star', 'skill1');
			i.classList.remove('active');
		});
		for(let i=0; i<skill1.length; i++) {
			if(i <= idx) {
				skill1[i].classList.replace('skill1', 'bxs-star');
				skill1[i].classList.add('active');
			} else {
				skill1[i].style.setProperty('--i', click);
				click++;
			}
		}
	});
});

//Skill2
skill2.forEach((item, idx)=> {
	item.addEventListener('click', function () {
		let click = 0;
		ratingSkill2.value = idx + 1;

		skill2.forEach(i=> {
			i.classList.replace('bxs-star', 'skill2');
			i.classList.remove('active');
		});
		for(let i=0; i<skill2.length; i++) {
			if(i <= idx) {
				skill2[i].classList.replace('skill2', 'bxs-star');
				skill2[i].classList.add('active');
			} else {
				skill2[i].style.setProperty('--i', click);
				click++;
			}
		}
	});
});

//Skill3
skill3.forEach((item, idx)=> {
	item.addEventListener('click', function () {
		let click = 0;
		ratingSkill3.value = idx + 1;

		skill3.forEach(i=> {
			i.classList.replace('bxs-star', 'skill3');
			i.classList.remove('active');
		});
		for(let i=0; i<skill3.length; i++) {
			if(i <= idx) {
				skill3[i].classList.replace('skill3', 'bxs-star');
				skill3[i].classList.add('active');
			} else {
				skill3[i].style.setProperty('--i', click);
				click++;
			}
		}
	});
});




