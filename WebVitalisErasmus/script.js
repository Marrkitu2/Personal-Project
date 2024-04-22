const navLinks = document.querySelectorAll('nav a');
const sections = document.querySelectorAll('.container > div');

// Ocultar todos los sub apartados excepto el de Inicio
document.querySelector('.inicio').style.display = 'block';
document.querySelector('.semanas').style.display = 'none';
document.querySelector('.sitios').style.display = 'none';
document.querySelector('.tiempo-libre').style.display = 'none';

navLinks.forEach(link => {
  link.addEventListener('click', event => {
    event.preventDefault();
    const href = link.getAttribute('href');

    // Ocultar todos los sub apartados
    sections.forEach(section => section.style.display = 'none');

    // Mostrar el sub apartado correspondiente al enlace pulsado
    document.querySelector(href).style.display = 'block';
  });
});
