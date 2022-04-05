import CCInput from './CCInput/CCInput.vue';
import CCButton from './CCButton/CCButton.vue';

export default {
  install: (app) => {
    app.component('CCButton', CCButton);
    app.component('CCInput', CCInput);
  },
};
