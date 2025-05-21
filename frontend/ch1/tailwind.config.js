// tailwind.config.ts
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}", // 이게 있어야 IntelliSense가 작동함
  ],
  theme: {
    extend: {},
  },
  plugins: [],
};
