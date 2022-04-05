// eslint-disable-next-line import/no-extraneous-dependencies
import { defineConfig } from 'vite';
// eslint-disable-next-line import/no-extraneous-dependencies
import vue from '@vitejs/plugin-vue';
import vueJsx from '@vitejs/plugin-vue-jsx';
import eslintPlugin from 'vite-plugin-eslint';
import * as path from 'path';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), vueJsx(), eslintPlugin()],
  base: '/',
  minify: 'esbuild',
  server: {
    port: 80,
    host: '127.0.0.1',
  },
  build: {
    rollupOptions: {
      output: {
        chunkFileNames: 'static/js/[name]-[hash].js',
        entryFileNames: 'static/js/[name]-[hash].js',
        assetFileNames: 'static/[ext]/[name]-[hash].[ext]',
      },
    },
  },
  resolve: {
    alias: [
      { find: '@', replacement: path.resolve('src') },
    ],
  },
  css: {
    preprocessorOptions: {
      scss: {
        additionalData: '@import "./src/assets/style/common_variable.scss";',
      },
    },
  },
  optimizeDeps: {
    include: ['lodash-es'],
  },
});
