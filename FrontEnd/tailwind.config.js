/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: "#006400",    // NUST Green
        secondary: "#003366",  // NUST Dark Blue
      }
    },
  },
  plugins: [
    require('daisyui'),
    require('@tailwindcss/forms')
  ],
  daisyui: {
    themes: ["light"],
  },
}